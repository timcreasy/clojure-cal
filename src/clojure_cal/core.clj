(ns clojure-cal.core
  (:require [print-month.core :as pm])
  (:gen-class))

(defn no-arg []
  (let [date-string (.format (java.text.SimpleDateFormat. "MM yyyy") (new java.util.Date))]
    (let [date-coll (clojure.string/split date-string #" ")]
      (let [cur-month (Integer. (first date-coll)) cur-year (Integer. (last date-coll))]
        (pm/print-month cur-month cur-year)))))

(defn month-year [month year]
  (let [month (Integer. month) year (Integer. year)]
    (pm/print-month month year)))

(defn -main
  ([] (no-arg))
  ([month year] (month-year month year)))
