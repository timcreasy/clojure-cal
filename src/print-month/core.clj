(ns print-month.core
  (:require [left-pad.core :as left-pad]))

(defn get-month-year-string [month year]
  (str
    (.format (java.text.SimpleDateFormat. "MMMM") (.parse (java.text.SimpleDateFormat. "yyyy-MM") (str year "-" month)))
    " "
    year
    "\n"))

(defn get-month-year-header-string [month year]
  (let [month-year-string (get-month-year-string month year)]
    (str
      (left-pad/get-left-pad month-year-string)
      month-year-string)))

(defn get-day-of-week-header-string []
  (str "Su Mo Tu We Th Fr Sa\n"))

(defn print-month [month year]
  (println
    (str
      (get-month-year-header-string month year)
      (get-day-of-week-header-string))))