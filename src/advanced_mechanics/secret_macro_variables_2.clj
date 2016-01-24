(ns advanced-mechanics.secret-macro-variables-2)

(defmacro inspect-caller-locals []
  (->> (keys &env)
       (map (fn [k] [`'~k k]))
       (into {})))

(println "No locals")
(println (macroexpand '(inspect-caller-locals)))
(println (inspect-caller-locals))
(println)
(println "One local")
(println (macroexpand '(let [foo "bar"] (inspect-caller-locals))))
(println (let [foo "bar"] (inspect-caller-locals)))
(println)
(println "Many locals")
(println (macroexpand '(let [foo "bar" baz "quux"] (inspect-caller-locals))))
(println (let [foo "bar" baz "quux"] (inspect-caller-locals)))

