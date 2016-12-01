(ns clojure-cal.core
  (:require [print-month.core :as pm])
  (:gen-class))

(defn -main [& args]
  (pm/print-month 12 2016))