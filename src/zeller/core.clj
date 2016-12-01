(ns zeller.core)

(defn get-current-day []
  (Integer. (.format (java.text.SimpleDateFormat. "dd") (new java.util.Date))))

(defn get-current-month []
  (Integer. (.format (java.text.SimpleDateFormat. "MM") (new java.util.Date))))

(defn get-current-year []
  (Integer. (.format (java.text.SimpleDateFormat. "yyyy") (new java.util.Date))))

; Get offset month for zeller's congruence
(defn get-zeller-month [month]
  (if (< month 3)
    (+ month 12)
    month))

(defn get-year-of-century [year]
  (mod year 100))

(defn get-zero-based-century [year]
  (quot year 100))

(defn get-sunday-indexed-day [zeller-day]
  (if (= zeller-day 0)
    6
    (mod (+ zeller-day 5) 6)))

; Get day of week of beginning of month using Zeller's congruence
; https://en.wikipedia.org/wiki/Zeller's_congruence
(defn get-day-of-month [day month year]
  (let [zmonth (get-zeller-month month)]
    (get-sunday-indexed-day
      (mod (- (+ day
                 (int (Math/floor (/ (* 13 (+ zmonth 1)) 5)))
                 year
                 (int (Math/floor (/ year 4)))
                 (int (Math/floor (/ year 400))))
              (int (Math/floor (/ year 100))))
           7))))
