(ns atomizer.plugins.logstate
  (:require [clojure.data :refer [diff]]))

(def trunc [s]
  (when (> (count s) 75)
    (str (subs s 0 75) "...")))

(defn logstate! [!app & {:keys [key]
                         :or {key :logstate}}]
  (add-watch !app key (fn [_key _ref old new]
                        (.log js/console "App state changed.")
                        (.log js/console "Old: " (trunc (pr-str old)))
                        (.log js/console "New: " (trunc (pr-str new)))
                        (.log js/console "Diff: " (pr-str (diff old new)))))
  !app)
