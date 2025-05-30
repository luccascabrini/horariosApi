A quantidade de horas que cada professor tem comprometido em aulas:

SELECT
    P.name AS Professor_Nome,
    SUM(TIME_TO_SEC(TIMEDIFF(CS.end_time, CS.start_time)) / 3600) AS Horas_Comprometidas
FROM
    PROFESSOR P
JOIN
    SUBJECT S ON P.id = S.taught_by
JOIN
    CLASS C ON S.id = C.subject_id AND S.taught_by = P.id
JOIN
    CLASS_SCHEDULE CS ON C.id = CS.class_id
GROUP BY
    P.name
ORDER BY
    Professor_Nome;
