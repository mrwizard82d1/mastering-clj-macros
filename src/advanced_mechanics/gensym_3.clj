(ns advanced-mechanics.gensym-3)

(defmacro make-adder [x]
  (let [y (gensym)]
    `(fn [~y] (+ ~x ~y))))

(println "This version of `make-adder` expands **differently** than")
(println "versions created previously.")
(println)
(println "Unhygienic-3 uses the symbols `x` and `y` in the expansion.")
(println (macroexpand `(advanced-mechanics.unhygienic-3/make-adder 10)))
(println)
(println "Gensym-3 uses the symbol `x` and a generated symbol in the expansion.")
(println (macroexpand `(make-adder 10)))
(println)
(println "If we again assign a value to the symbol `y` in the environment,")
(println "evaluating these expansions will produce different values.")
(println)
(def y 100)
(println)
(println "Unhygienic-3 hides the value of `y` in the namespace.")
(println (macroexpand '(advanced-mechanics.unhygienic-3/make-adder (+ y 3))))
(println ((advanced-mechanics.unhygienic-3/make-adder (+ y 3)) 5))
(println)
(println "Gensym-3 allows use of the symbol `y` from the namespace.")
(println (macroexpand '(make-adder (+ y 3))))
(println ((make-adder (+ y 3)) 5))