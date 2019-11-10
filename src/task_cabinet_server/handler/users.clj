(ns task-cabinet-server.handler.users
  (:require [clojure.spec.alpha :as s]
            [clojure.walk :as w]))

(s/def ::id int?)
(s/def ::name string?)
(s/def ::email string?)
(s/def ::password string?)
(s/def ::updated_at int?)
(s/def ::created_at int?)
(s/def ::path-params (s/keys :req-un [::id]))
(s/def ::users-update-param (s/keys :req-un [::name ::email]))
(s/def ::user-get-response (s/keys :req-un [::name ::email ::created_at ::updated_at]))

(defn users-app [env]
  ["/users"
   {:swagger {:tags ["users"]}}
   ["/:id"
    {:get {:summary "get user information"
           :description "for debug id \"1\" authorization  \"gXqi4mnXg8KyuSKS5XlK\""
           :swagger {:security [{:ApiKeyAuth []}]}
           :parameters {:path ::path-params
                        :headers {:Authorization string?}}
           :responses {200 {:body {:result ::user-get-response}}}
           :handler (fn [{:keys [parameters headers path-params]}]
                      (let [{:keys [authorization]} (w/keywordize-keys headers)
                            id (-> path-params :id Integer/parseInt)]
                        (if (and (= id 1) (= authorization "gXqi4mnXg8KyuSKS5XlK"))
                          {:status 200
                           :body
                           {:result
                            {:name "Debug User"
                             :created_at 1572566400000
                             :updated_at 1572566411000
                             :email "debug@d.gmail.com"}}}
                          {:status 401})))}
     :patch {:summary "update user information"
             :description "for debug id \"1\" authorization\"gXqi4mnXg8KyuSKS5XlK\""
             :swagger {:security [{:ApiKeyAuth []}]}
             :parameters {:path ::path-params
                          :body ::users-update-param
                          :headers {:Authorization string?}}
             :responses {200 {:body {:result ::user-get-response}}}
             :handler (fn [{:keys [parameters headers path-params]}]
                        (let [{:keys [authorization]} (w/keywordize-keys headers)
                              id (-> path-params :id Integer/parseInt)
                              {{:keys [name email]} :body} parameters]
                          (if (and (= id 1) (= authorization "gXqi4mnXg8KyuSKS5XlK"))
                            {:status 200
                             :body
                             {:result
                              {:name name
                               :created_at 1572566400000
                               :updated_at 1572566421000
                               :email email}}}
                            {:status 401})))}
     :delete {:summary "delete user"
              :description "for debug password is  \"testPass10\""
              :swagger {:security [{:ApiKeyAuth []}]}
              :parameters {:path ::path-params
                           :query {:password ::password}}
              :response {}
              :handler (fn [{:keys [parameters headers path-params]}]
                         (let [{:keys [authorization]} (w/keywordize-keys headers)
                               id (-> path-params :id Integer/parseInt)
                               {{:keys [password]} :query} parameters]
                           (if (and (= id 1) (= authorization "gXqi4mnXg8KyuSKS5XlK") (= password "testPass10"))
                             {:status 200}
                             {:status 401})))}}]])
