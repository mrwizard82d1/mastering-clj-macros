(ns advanced-mechanics.syntax-quote-6
  (:refer-clojure :exclude [map]))

(def map {:a 1 :b 2})

(println "When I evaluate the expression, `(map (range 10))`")
(println "I expect to see the squares of the numbers 0 to 9, inclusive.")
(println "Instead, I see the numbers 0 to 9, inclusive.")
(println)
(println (advanced-mechanics.syntax-quote-5/squares (range 10)))
(println)
(println "This surprising result occurs because `(squares (range 10))`")
(println "expands to the expression `(map #(* % %) (range 10))`,")
(println "but `map`, in **this** namespace, is an actual map, `{:a 1  :b 2}`.")
(println)
(println "Fully expanding the expression, `(squares (range 10))`, produces:")
(println)
(println (macroexpand '(advanced-mechanics.syntax-quote-5/squares (range 10))))
(println)
(println "Because the symbol, `map`, in this namespace, evaluates to" (str map ","))
(println "the resulting expression is the alternative form of a")
(println "map lookup, supplying a default value if the value sought")
(println "cannot be found. Since looking up the function in the map fails,")
(println "the result of the expression is the third argument; that is, the")
(println "value of `(range 10)`.")

(println (advanced-mechanics.syntax-quote-5/squares :a))

;; Note that the following line **does not** print 'clojure.core/map but 'map from **this** namespace.
(println (first (macroexpand '(advanced-mechanics.syntax-quote-5/squares (range 10)))))

(println (map :non-existent-key :default-value))