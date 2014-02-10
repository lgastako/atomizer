(ns atomizer.plugins.autoload)

(defn load!
  "Loads the state of '!app' from 'path' in 'storage' immediately."

  [!app & {:keys [path storage]
           :or {path "atomizer.default.app"
                storage atomizer.services.storage.local}}]
  (when-let [app (storage/get path)]
    (reset! !app app))
  !app)

(defn load-or!
  "Loads the state of '!app' from 'path' in 'storage' immediately."

  [!app make-app & {:keys [path storage]
                    :or {path "atomizer.default.app"
                         storage atomizer.services.storage.local}}]
  (reset! !app (if-let [app (storage/get path)]
                 app
                 (make-app)))
  !app)
