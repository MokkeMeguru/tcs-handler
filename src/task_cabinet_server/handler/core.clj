(ns task-cabinet-server.handler.core
  (:require [reitit.ring :as ring]
            [reitit.core :as r]
            [ring.middleware.cors :refer [wrap-cors]]
            [reitit.swagger :as swagger]
            [ring.logger :refer [wrap-with-logger]]))

;; https://enpitut2019.github.io/
;; http://localhost
;; https://localhost

;; (defn cors-handler [handler]
;;   (wrap-cors handler :access-control-allow-origin [#"http://localhost" #"https://localhost" #"https://enpitut2019.github.io"]))

;; (def app
;;   (ring/ring-handler
;;    (ring/router
;;     [["/swagger.json"
;;       {:get {:no-doc true
;;              :swagger {:info {:title "my-api"}
;;                        :basePath "/"}
;;              :handler (swagger/create-swagger-handler)}}]
;;      ["/ping" (constantly {:status 200 :body "ping"})]])
;;    (ring/routes
;;     (swagger-ui)
;;     (ring/create-default-handler))
;;    {:middleware [cors-handler wrap-with-logger]}))



;; (app {:request-method :get, :uri "/ping"})

;; (app {:request-method :get, :uri "/ping"})

