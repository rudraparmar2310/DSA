WITH DailyTotals AS (
    SELECT
        visited_on,
        SUM(amount) AS day_amount
    FROM Customer
    GROUP BY visited_on
),
MovingAverage AS (
    SELECT
        visited_on,
        SUM(day_amount) OVER (
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        AVG(day_amount) OVER (
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS average_amount
    FROM DailyTotals
)
SELECT
    visited_on,
    amount,
    ROUND(average_amount, 2) AS average_amount
FROM MovingAverage
WHERE visited_on >= (
    SELECT MIN(visited_on) + INTERVAL '6 days'
    FROM Customer
)
ORDER BY visited_on;