;; 배포용 jar 만들때 또는 DB 에 연결하여 로컬서버를 띄울 때,
;; lein 의 profiles 를 이용하여 독립적으로 분리/관리 할 수 있다.
{

 ;; staging 서버 배포용 uberjar 만들때 > lein with-profile +env/staging uberjar
 ;; production 서버 배포용 uberjar 만들때 > lein with-profile +env/production uberjar

 :env/staging    {;; +env/staging 할 경우 아래의 resources path 가 추가 된다.
                  :resource-paths ["resources-staging"]

                  ;; +env/staging 할 경우 아래의 dependency 가 추가 된다.
                  :dependencies   [[com.fasterxml.jackson.core/jackson-core "2.9.6"]
                                   [io.sentry/sentry-logback "1.7.5"]]}

 :env/production {:resource-paths ["resources-production"]}

 ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

 ;; aws rds 의 DB 를 바라보고 서버를 띄울 때 > lein with-profile +db/rds server
 ;; local 의 DB 를 바라보고 서버를 띄울 때 > lein with-profile +db/local server

 :db/rds         {:env {:db-host "cloud-dev.cledffj1luwp.ap-northeast-2.rds.amazonaws.com"
                        :db-port "5432"}}

 :db/local       {:env {:db-host "localhost"
                        :db-port "5555"}}

 :db/ci          {:env {:db-host "postgres"
                        :db-port "5432"}}}