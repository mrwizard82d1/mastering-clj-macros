(ns advanced-mechanics.secret-macro-variables-3)

(defmacro inspect-caller-locals-1 []
  (->> (keys &env)
       (map (fn [k] [`(quote ~k) k]))
       (into {})))

(defmacro inspect-caller-locals-2 []
  (->> (keys &env)
       (map (fn [k] [(list 'quote k) k]))))

(println "No locals: identical results.")
(println (inspect-caller-locals-1))
(println (inspect-caller-locals-2))
(println)
(println "One local")
(let [foo "bar"]
  (println (inspect-caller-locals-1))i
  (println (inspect-caller-locals-2)))
(println)
(println "Many locals")
(let [foo "bar" baz "quux"] (inspect-caller-locals))

