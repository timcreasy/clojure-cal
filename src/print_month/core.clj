(ns print-month.core
  (:require [left-pad.core :as left-pad]
            [zeller.core :as zeller]))

(defn get-month-year-string [month year]
  (str
    (.format (java.text.SimpleDateFormat. "MMMM") (.parse (java.text.SimpleDateFormat. "yyyy-MM") (str year "-" month)))
    " "
    year
    "\n"))

(defn get-month-year-header-string [month year]
  (let [month-year-string (get-month-year-string month year)]
    (str
      (left-pad/get-header-left-pad month-year-string)
      month-year-string)))

(defn get-day-of-week-header-string []
  (str "Su Mo Tu We Th Fr Sa\n"))

(defn is-leap-year? [year]
  (or
    (and
      (not= (mod year 100) 0)
      (= (mod year 4) 0))
    (= (mod year 400) 0)))

(defn get-days-in-month [month year]
  (case month
    1 31
    2 (if (is-leap-year? year)
        29
        28)
    3 31
    4 30
    5 31
    6 30
    7 31
    8 31
    9 30
    10 31
    11 30
    12 31))

(defn get-day-string [day]
  (if (< day 10)
    (str " " day)
    (str day)))

(defn get-days-string [month year]
  (apply str
    (let [days-in-month (get-days-in-month month year)]
      (loop [i 1 days-string-collec []]
        (let [day-of-month (zeller/get-day-of-month i month year)]
          (if (<= i days-in-month)
            (recur (inc i) (if (and (not= 0 day-of-month) (= 0 (mod day-of-month 6)))
                             (conj days-string-collec (str (get-day-string i) " \n"))
                             (conj days-string-collec (str (get-day-string i) " "))))
            days-string-collec))))))

(defn print-month [month year]
  (let [start-day-of-week (zeller/get-day-of-month 1 month year)]
    (println
      (str
        (get-month-year-header-string month year)
        (get-day-of-week-header-string)
        (left-pad/get-start-week-left-pad start-day-of-week)
        (get-days-string month year)))))