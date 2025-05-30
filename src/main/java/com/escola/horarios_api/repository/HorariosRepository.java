package com.escola.horarios_api.repository;

import com.escola.horarios_api.dto.ProfessorHorasDTO;
import com.escola.horarios_api.dto.SalaOcupadaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public class HorariosRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_HORAS_PROFESSOR =
            "SELECT " +
                    "    P.name AS Professor_Nome, " +
                    "    SUM(CAST(EXTRACT(EPOCH FROM (CS.end_time - CS.start_time)) AS DOUBLE) / 3600) AS Horas_Comprometidas " +
                    "FROM " +
                    "    PROFESSOR P " +
                    "JOIN " +
                    "    SUBJECT S ON P.id = S.taught_by " +
                    "JOIN " +
                    "    CLASS C ON S.id = C.subject_id AND S.taught_by = P.id " +
                    "JOIN " +
                    "    CLASS_SCHEDULE CS ON C.id = CS.class_id " +
                    "GROUP BY " +
                    "    P.name " +
                    "ORDER BY " +
                    "    Professor_Nome";

    private static final String SQL_SALAS_OCUPADAS =
            "SELECT " +
                    "    R.name AS Nome_Sala, CS.day_of_week AS Dia_Da_Semana, " +
                    "    CS.start_time AS Hora_Inicio, CS.end_time AS Hora_Fim, " +
                    "    C.code AS Codigo_Turma, S.name AS Nome_Materia, P.name AS Nome_Professor " +
                    "FROM " +
                    "    CLASS_SCHEDULE CS " +
                    "JOIN " +
                    "    ROOM R ON CS.room_id = R.id " +
                    "JOIN " +
                    "    CLASS C ON CS.class_id = C.id " +
                    "JOIN " +
                    "    SUBJECT S ON C.subject_id = S.id " +
                    "JOIN " +
                    "    PROFESSOR P ON S.taught_by = P.id " +
                    "ORDER BY " +
                    "    R.name, " +
                    "    CASE CS.day_of_week " + // Esta é a correção para a função FIELD()
                    "        WHEN 'Segunda' THEN 1 " +
                    "        WHEN 'Terça' THEN 2 " +
                    "        WHEN 'Quarta' THEN 3 " +
                    "        WHEN 'Quinta' THEN 4 " +
                    "        WHEN 'Sexta' THEN 5 " +
                    "        WHEN 'Sábado' THEN 6 " +
                    "        WHEN 'Domingo' THEN 7 " +
                    "        ELSE 8 " + // Para qualquer outro valor não mapeado (opcional, mas bom ter)
                    "    END, " +
                    "    CS.start_time";

    private static final String SQL_TODAS_SALAS = "SELECT name FROM ROOM ORDER BY name";


    public List<ProfessorHorasDTO> findHorasComprometidasPorProfessor() {
        return jdbcTemplate.query(SQL_HORAS_PROFESSOR, (rs, rowNum) -> new ProfessorHorasDTO(
                rs.getString("Professor_Nome"),
                rs.getDouble("Horas_Comprometidas")
        ));
    }

    public List<SalaOcupadaDTO> findAllHorariosOcupados() {
        return jdbcTemplate.query(SQL_SALAS_OCUPADAS, (rs, rowNum) -> new SalaOcupadaDTO(
                rs.getString("Nome_Sala"),
                rs.getString("Dia_Da_Semana"),
                rs.getObject("Hora_Inicio", LocalTime.class),
                rs.getObject("Hora_Fim", LocalTime.class),
                rs.getString("Codigo_Turma"),
                rs.getString("Nome_Materia"),
                rs.getString("Nome_Professor")
        ));
    }

    public List<String> findAllRoomNames() {
        return jdbcTemplate.queryForList(SQL_TODAS_SALAS, String.class);
    }
}