(ns atomizer.services.storage.local
  (:require [cljs.reader :refer [read-string]]))

(defn put! [k v]
  (aset js/localStorage k (pr-str v)))

(defn get [k]
  (when-let [serialized (aget js/localStorage k)]
    (read-string serialized)))
