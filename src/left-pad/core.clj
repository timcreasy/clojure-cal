(ns left-pad.core)

(defn get-pad-amount [text]
  (quot
    (- 20 (count text))
    2))

(defn get-left-pad [text]
  (apply str (repeat (get-pad-amount text) " ")))