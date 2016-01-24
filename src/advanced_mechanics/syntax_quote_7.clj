(ns advanced-mechanics.syntax-quote-7)

(defmacro squares [xs] `(map #(* % %) ~xs))

(println (squares (range 10)))
