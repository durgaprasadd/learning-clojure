(ns medical-transactions.core)

(defn update-inventory [inventory {:keys [from to item quantity]}]
  (-> inventory
      (update-in [from item] - quantity)
      (update-in [to item] + quantity)
      ))

(defn perform-transactions [inventory transactions] (reduce update-inventory inventory transactions))
