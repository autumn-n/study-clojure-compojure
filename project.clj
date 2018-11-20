(defproject study-clojure-compojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"

  :dependencies [[org.clojure/clojure "1.9.0"]

                 [ring "1.6.3"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-defaults "0.3.2"]

                 [compojure "1.6.1"]]

  :plugins []

  :repl-options {:init-ns study-clojure-compojure.core :init (run)}

  ;; https://github.com/technomancy/leiningen/blob/master/doc/PROFILES.md
  :profiles {:dev     {:dependencies [[javax.servlet/servlet-api "2.5"]
                                      [ring/ring-mock "0.3.0"]]

                       ;; lein-ring 에서 제공하는 lein ring $SUBTASK 로 서버 바로 띄우기.
                       :plugins      [[lein-ring "0.9.7"]]
                       :ring         {:handler study-clojure-compojure.handler/app}}

             ;; jetty server 가 embed 된 jar 파일로 서버 띄우기.
             :uberjar {:aot  :all
                       :main study_clojure_compojure.core}})
