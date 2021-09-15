(ns life-perspective.routes.home
  (:require
   [life-perspective.layout :as layout]
   [life-perspective.db.core :as db]
   [clojure.java.io :as io]
   [life-perspective.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn life-page [request]
  (layout/render request "life.html"))

(defn home-routes []
  [ "" 
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/life" {:get life-page}]
   ["/about" {:get about-page}]])

