(ns task-cabinet-server.handler.task
  (:require [clojure.spec.alpha :as s]
            [clojure.walk :as w]))

(s/def ::user-id int?)
(s/def ::path-params (s/keys :req-un [::user-id]))

(s/def ::name string?)
(s/def ::description string?)
(s/def ::category string?)
(s/def ::deadline int?)
(s/def ::estimate int?)
(s/def ::create-task-params
  (s/keys :req-un [::name ::deadline ::estimate]
          :opt-un [::description ::category]))

(def create-task
  {:summary "create a task"
   :description "for debug id \"1 \"  authorization  \"gXqi4mnXg8KyuSKS5XlK\""
   :swagger {:security [{:ApiKeyAuth []}]}
   :parameters
   {:path ::path-params
    :body ::create-task-params}
   :responses
   })

(defn task-app [env]
  ["/tcs/users/:user-id"
   {:swagger {:tags ["task"]}}
   ["/task"
    {:post (fn [] {:status 200})}]
   ["/task/:id"
    {:get (fn [] {:status 200})
     :delete (fn [] {:status 200})
     :patch (fn [] {:status 200})}]
   ["/task/:id/complete"
    {:put (fn [] {:status 200})}]])
