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





;; (def dataset [6 12 18 30 42 48])
;; ;;; 6 48
;; (def first-clust [[6 12 18 24] [30 42 48]])
;; (def first-clust-mean (map #(/ (apply + %) (count %)) first-clust)) ;; 15 40
;; (def second-clust [[6 12 18 24] [30 42 48]])
;; (def second-clust-mean (map #(/ (apply + %) (count %)) second-clust)) ;; 15 40
;; ;; end

;; ;; 42 48
;; (def first-clust [[6 12 18 30 42] [48]])
;; (def first-clust-mean (map #(/ (apply + %) (count %)) first-clust)) ;; 108/5 48
;; (map #(- dataset %) first-clust-mean)

;; (- [1 2 3 4] 1)
