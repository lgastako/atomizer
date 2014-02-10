(ns atomizer.plugins.save-on-unload)

(defn save-on-unload!
  "Saves the state of '!app' to 'path' in 'storage'.
   Default storage is browser localStorage.
   Alternatives include: atomizer.services.storage.local (default)
                         atomizer.services.storage.session
                         atomizer.services.storage.cookie
                         atomizer.services.storage.devnull
  "
  [!app & {:keys [path storage]
           :or {path "atomizer.default.app"
                storage atomizer.services.storage.local}}]
  (.addEventListener js/window "beforeunload"
                     #(storage/put! path @!app))
  !app)
