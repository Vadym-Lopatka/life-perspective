(ns life-perspective.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [life-perspective.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[life-perspective started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[life-perspective has shut down successfully]=-"))
   :middleware wrap-dev})
