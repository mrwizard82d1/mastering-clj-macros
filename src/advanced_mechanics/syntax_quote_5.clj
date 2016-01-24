(ns advanced-mechanics.syntax-quote-5)

(defmacro squares [xs]
  (list 'map '#(* % %) xs))

(println (squares (range 10)))
