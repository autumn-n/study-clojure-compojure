(ns study-clojure-compojure.middleware)

(defn wrap-custom-middleware-1
  [handler]
  (fn [req]
    (println "pre-middleware-1")
    (let [res (handler req)]
      (println "post-middleware-1")
      res)))

(defn wrap-custom-middleware-2
  [handler]
  (fn [req]
    (println "pre-middleware-2")
    (let [res (handler req)]
      (println "post-middleware-2")
      res)))

(defn wrap-custom-middleware-3
  [handler]
  (fn [req]
    (println "pre-middleware-3")
    (let [res (handler req)]
      (println "post-middleware-3")
      res)))