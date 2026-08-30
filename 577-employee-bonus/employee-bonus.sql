SELECT e.name, b.bonus
FROM Employee e
LEFT JOIN Bonus b
ON e.empID = b.empID
GROUP BY e.empID, e.name, b.bonus
HAVING b.bonus IS NULL OR b.bonus < 1000;