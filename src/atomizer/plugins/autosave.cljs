(ns atomizer.plugins.autosave)

(defn autosave!
  "Saves the state of '!app' to 'path' in 'storage' every time it changes."

  [!app & {:keys [path storage key]
           :or {path "atomizer.default.app"
                storage atomizer.services.storage.local
                key :autosave}}]
  (add-watch !app key #(storage/put path %))
  !app)
