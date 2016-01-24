(ns advanced-mechanics.gensym-4)

(defmacro make-adder [x]
  `(fn [y#] (+ ~x y#)))

(println "This version of `make-adder` uses auto-gensym by adding the")
(println "suffix '#' to the 'local' symbol.")
(println)
(println "Gensym-4 uses the symbol `x` and a generated symbol in the expansion.")
(println (macroexpand `(make-adder 10)))
(println)
(println "If we again assign a value to the symbol `y` in the environment,")
(println "evaluating this expansions will produce different values.")
(println)
(def y 100)
(println "Gensym-4 allows use of the symbol `y` from the namespace.")
(println "Notice the distinction between the 'auto y' symbol and `y`.")
(println (macroexpand '(make-adder (+ y 3))))
(println ((make-adder (+ y 3)) 5))