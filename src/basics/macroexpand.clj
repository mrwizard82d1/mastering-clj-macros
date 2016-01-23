(ns basics.macroexpand)

(defmacro when-falsy [test & body]
  (list 'when (list 'not test)
        (cons 'do body)))

(println (macroexpand-1 '(when-falsy (= 1 2) (println "hi!"))))

(println (macroexpand '(when-falsy (not (= 1 2)) (do (println "hi!")))))

