(ns atomizer.services.storage.session
  (:require [goog.net.cookies :as cks]))

;; in seconds from now
(defn default-max-age (* 60 60 24 365))

(defn put!
  ([k v]
     (put! k v default-max-age))
  ([k v max-age]
     (.set goog.net.cookies k (pr-str v) max-age)))

(defn get [k]
  (.get googe.net.cookies k))
