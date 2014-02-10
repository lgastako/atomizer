(ns atomizer.services.storage.session
  (:require [cljs.reader :refer [read-string]]))

(defn put! [k v]
  (aset js/sessionStorage k (pr-str v)))

(defn get [k]
  (when-let [serialized (aget js/sessionStorage k)]
    (read-string serialized)))
