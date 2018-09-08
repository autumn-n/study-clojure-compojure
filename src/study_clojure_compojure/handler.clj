(ns study-clojure-compojure.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [study-clojure-compojure.middleware :refer :all]))

(defroutes app-routes-1
  (GET "/routes-1" [] "Hello World! 1"))

(defroutes app-routes-2
  (GET "/routes-2" [] "Hello World! 2"))

(defroutes app-routes-3
  (context "/routes-3" _                                    ;; context 로 공통 부모 path 로 묶을 수 있다.
    (GET "/" [] "Hello World! 3")                           ;; /routes-3
    (GET "/sub-1" [] "Hello World! 3-1")))                  ;; /routes-3/sub-1

;; 첫번째 defroutes - route 들의 모음
(defroutes app-routes
  (GET "/" [] "Hello World")                                ;; 직접 route 를 넣을 수도 있고,
  app-routes-1                                              ;; 또다른 routes 들을 넣을 수도 있다.
  app-routes-2
  app-routes-3
  (route/not-found "Not Found"))

(def app                                                    ;; jetty run 할 때 바라보는 entry-point
  (-> app-routes
      wrap-custom-middleware-1
      wrap-custom-middleware-2
      wrap-custom-middleware-3
      (wrap-defaults site-defaults)))
