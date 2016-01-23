(ns basics.broken-macro-1)

(defmacro broken-when [test & body]
  (list test (cons 'do body)))

#_(broken-when (= 1 1)
             (println "Math works!"))


(println (macroexpand-1 '(broken-when (= 1 1) (println "Math works!"))))