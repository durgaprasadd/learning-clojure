(ns medical-transactions.core-test
  (:require [clojure.test :refer :all]
            [medical-transactions.core :refer :all]))

(def initial-inventory
  {
   :Warehouse
   {
    :Paracetamol 10
    :Ibuprofen   50
    :Syringe     80
    :Scalpel     100
    }

   :ICU
   {
    :Paracetamol 0
    :Ibuprofen   20
    :Syringe     7
    :Scalpel     8
    }

   :Dispensary
   {
    :Paracetamol 50
    :Ibuprofen   33
    :Syringe     10
    :Scalpel     80
    }
   }
  )

(def transactions
  [
   {:from :Warehouse
    :to :Dispensary
    :item :Paracetamol
    :quantity 2}

   {:from :Warehouse
    :to :Dispensary
    :item :Ibuprofen
    :quantity 5}

   {:from :Dispensary
    :to :ICU
    :item :Syringe
    :quantity 2}

   {:from :Warehouse
    :to :ICU
    :item :Scalpel
    :quantity 10}
   ]
  )

(def final-inventory
  {
   :Warehouse
   {
    :Paracetamol 8
    :Ibuprofen   45
    :Syringe     80
    :Scalpel     90
    }

   :ICU
   {
    :Paracetamol 0
    :Ibuprofen   20
    :Syringe     9
    :Scalpel     18
    }

   :Dispensary
   {
    :Paracetamol 52
    :Ibuprofen   38
    :Syringe     8
    :Scalpel     80
    }
   }
  )

(deftest first-test
  (testing "checking result after multiple transactions happened"
    (is final-inventory (perform-transactions initial-inventory transactions))))
