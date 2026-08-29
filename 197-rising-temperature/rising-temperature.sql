select t.id
FROM Weather w
JOIN Weather t
ON t.recordDate=w.recordDate+INTERVAL'1 DAY'
WHERE t.temperature>w.temperature;