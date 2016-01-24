(ns advanced-mechanics.gensym-1)

(defmacro squares [xs]
  `(map (fn [x] (* x x)) ~xs))

(println "Evaluating `(squares (range 10))` throws an exception.")
(squares (range 10))
