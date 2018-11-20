(ns study-clojure-compojure.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [study-clojure-compojure.handler :refer [app]])
  ;; uberjar 의 main 으로 지정된 namespace 에는 :gen-class 가 반드시 설정되어야 함.
  (:gen-class))

(defn run []
  (run-jetty app {:port  (Integer/valueOf (or (System/getenv "port") "3000"))
                  :join? false}))

(defn -main [& args]
  "uberjar 로 만든 jar 파일 실행 시 Entry-Point"
  (run))