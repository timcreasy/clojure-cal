(ns left-pad.core)

(defn get-header-pad-amount [text]
  (quot
    (- 20 (count text))
    2))

(defn get-header-left-pad [text]
  (apply str (repeat (get-header-pad-amount text) " ")))

(defn get-start-week-left-pad [start-day]
  (apply str (repeat (* start-day 3) " ")))