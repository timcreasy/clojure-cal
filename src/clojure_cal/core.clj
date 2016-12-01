(ns clojure-cal.core
  (:require [zeller.core :as z]
            [print-month.core :as pm])
  (:gen-class))

(defn -main [& args]
  (z/get-start-day-of-month (z/get-current-day) (z/get-current-month) (z/get-current-year)))
