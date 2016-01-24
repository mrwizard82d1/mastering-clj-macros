(ns advanced-mechanics.unhygienic-3)

(defmacro make-adder [x]
  `(fn [~'y]
     (+ ~x ~'y)))

(println "Expanding `make-adder` produces the expected result:")
(println)
(println (macroexpand '(make-adder 10)))
(println)
(println "That is, it expands to a function of a single argument,")
(println "y, that adds 10 to y when evaluated.")
(println)
(println "However, when we use it in an environment in which the")
(println "symbol, `y`, is **bound**, we get a strange result.")

(def y 100)

(println)
(println "Evaluating `y` produces" y)
(println "But evaluating`((make-adder (+ y 3) 5)` **does not** produce")
(println "108 but instead produces")
(println)
(println ((make-adder (+ y 3)) 5))

(println)
(println "The macroexpansion of the expression `(make-adder (+ y 3)' is")
(println)
(println (macroexpand '(make-adder (+ y 3))))
(println)
(println "Notice that this expansion **does not** use the value of `y`")
(println "from the enclosing environment; instead, because our macro uses")
(println "`~x`, the expansion substitutes the **expression** supplied for")
(println "`x` in the expansion. The expression was supplied was `(+ y 3)`.")
(println "Because we are expanding a macro, this expression **is not**")
(println "evaluated but is simply substituted. In the resulting expansion,")
(println "the symbol `'advanced-mechanics.unhygienic-3/y` is hidden by the")
(println "function argument, `y`.")
