(ns advanced-mechanics.assert-no-syntax-quote)

(defmacro my-assert [x]
  ; Check the dynamic var `clojure.core/*assert* to make sure assertions are enabled (when *assert*
  (list 'when-not x
        (list 'throw
              (list 'new 'AssertionError
                    (list 'str "Assert failed:"
                          (list 'pr-str
                                (list 'quote x)))))))

#_(do
  (println "Assert false value")
  (my-assert (= 1 2)))

(do
  (println "Assert true value")
  (my-assert (= 1 1)))


