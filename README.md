# 💊 SPARADRAP - Système de Gestion Pharmacie

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Swing](https://img.shields.io/badge/GUI-Swing-blue.svg)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![License](https://img.shields.io/badge/License-Educational-green.svg)](LICENSE)

> Application de gestion interne pour pharmacie développée en Java Swing dans le cadre de l'ECF Java - Formation CCP Développeur d'Applications

## 🎯 Description

**SPARADRAP** est une application desktop complète de gestion pour pharmacie permettant :
- 🏥 Gestion des clients, médecins et mutuelles
- 💊 Suivi de l'inventaire des médicaments
- 📝 Création et gestion des ordonnances
- 🛒 Processus d'achat (direct et sur ordonnance)
- 💰 Calcul automatique des remboursements
- 📊 Historique complet des transactions

## 🚀 Installation

### Prérequis
- **Java 21** ou supérieur
- **Git** (pour le clonage)
- **IntelliJ IDEA** (recommandé) ou tout IDE Java

### Installation et Lancement

```bash
# Cloner le repository
git clone https://github.com/Leos51/Sparadrah_ecf.git
cd sparadrap-ecf

# Option 1: Avec IntelliJ IDEA
# - Ouvrir le projet
# - Localiser src/fr/sparadrah/ecf/controller/Main.java
# - Clic droit → Run 'Main'

# Option 2: En ligne de commande
javac -d out -cp src src/fr/sparadrah/ecf/controller/Main.java
java -cp out fr.sparadrah.ecf.controller.Main
```

🎮 **Lancement direct** : L'application démarre avec des données de test pré-chargées pour une utilisation immédiate.

---

## ⭐ Fonctionnalités Principales

### 🏠 **Dashboard Interactif**
- Accès rapide aux fonctionnalités
- Informations clients/médecins en temps réel

### 👥 **Gestion Complète des Clients**
```java
// Fonctionnalités disponibles
✅ CRUD complet (Créer, Lire, Modifier, Supprimer)
🔍 Recherche multicritères (nom, NIR, email, ville)
📋 Fiche détaillée avec historique d'achats
🏥 Association médecin traitant et mutuelle
```

### 👨‍⚕️ **Gestion des Médecins**
```java
// Capacités système
✅ Gestion des médecins avec numéro RPPS
👥 Visualisation des patients associés  
📋 Historique des ordonnances prescrites
🔍 Recherche par nom et zone géographique
```

### 💊 **Inventaire Intelligent**
```java
// Gestion avancée des stocks
✅ Catalogue avec catégories
📦 Suivi temps réel des quantités
⚠️ Alertes automatiques stock faible
🔄 Mise à jour automatique lors des ventes
```

### 📝 **Système d'Ordonnances**
```java
// Workflow complet
✅ Création d'ordonnances personnalisées
🔗 Association médecin-patient-médicaments
📅 Suivi chronologique des prescriptions
✅ Validation automatique lors des achats
```

---

## 🛒 Processus d'Achat Avancé

### **Achat Direct** 🛍️
1. **Sélection client** → Recherche et choix
2. **Constitution panier** → Ajout médicaments + quantités
3. **Calcul automatique** → Total
4. **Validation** → Confirmation et mise à jour stocks

### **Achat sur Ordonnance** 📋
1. **Sélection client** → Auto-chargement des ordonnances
2. **Choix ordonnance** → Validation médecin/patient
3. **Pré-remplissage panier** → Médicaments prescrits
4. **Calcul remboursement** → Taux mutuelle automatique
5. **Validation conformité** → Vérification prescription

```java
// Exemple de calcul automatique
double total = calculateTotal();
double remboursement = total * client.getMutuelle().getTauxRemboursement();
double aPayer = total - remboursement;
```

---

## 🏗️ Architecture Technique

### **Pattern MVC Strict**
```
📁 src/fr/sparadrah/ecf/
├── 🎮 controller/     # Logique métier
│   ├── person/        # Gestion personnes ( customer, doctor , mutuelle)
│   ├── medicine/      # Gestion médicaments  (categorie, médicament, prescription)
│   └── purchase/      # Gestion achats 
├── 📊 model/          # Entités de données
│   ├── person/        # Customer, Doctor, MutualInsurance
│   ├── medicine/      # Medicine, Category, Prescription
│   ├── purchase/      # Purchase, CartItem
│   └── lists/         # Collections (simulation BDD)
├── 🖥️ view/
│   ├── swingview/ # Interface utilisateur Swing
│   │   ├── customer/      # Interfaces clients
│   │   ├── doctor/        # Interfaces médecins
│   │   └── purchases/     # Interfaces achats
│   └── consoleview/ # Interface utilisateur console
│       ├── customer/      # Interfaces clients
│       ├── doctor/        # Interfaces médecins
│       └── purchases/     # Interfaces achats  
└── 🔧 utils/          # Utilitaires
    ├── validator/     # Validation données
    └── exception/     # Exceptions métier
```

### **Design System Cohérent**
```java
// Palette de couleurs professionnelle
PRIMARY_COLOR = #2980B9    // Bleu principal
SUCCESS_COLOR = #2ECC71    // Vert validation
DANGER_COLOR = #E74C3C     // Rouge suppression
BACKGROUND = #ECF0F1       // Gris interface


```

---

## 🔒 Sécurité et Validation

### **Validations Implémentées**
| Donnée | Validation | Exemple |
|--------|------------|---------|
| **NIR** | Format + Clé Luhn | `1234567890123` |
| **Email** | RFC 5322 | `user@domain.com` |
| **Téléphone** | Format français | `01.23.45.67.89` |
| **Code Postal** | 5 chiffres France | `51000` |
| **RPPS Médecin** | Unicité + format | `12345678901` |
| **Dates** | Format dd/MM/yyyy | `25/12/2024` |


---

## 📊 Données de Démonstration

Au premier lancement, l'application se charge avec :

```java
📋 Données préchargées
├── 👥 4 clients avec profils variés
├── 👨‍⚕️ 3 médecins 
├── 💊 6 médicaments (4 catégories)
├── 🏥 2 mutuelles (taux différents)  
├── 📝 Ordonnances d'exemple
└── 🛒 Historique d'achats de démonstration
```

---

## 🛠️ Technologies et Outils

| Technologie | Version | Utilisation |
|-------------|---------|-------------|
| ![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=java&logoColor=white) | **21** | Langage principal |
| ![Swing](https://img.shields.io/badge/Swing-Built--in-4285F4?style=flat) | **Built-in** | Interface graphique |
| ![IntelliJ](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=flat&logo=intellij-idea&logoColor=white) | **2024** | IDE développement |
| ![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white) | **Latest** | Contrôle de version |

**Aucune dépendance externe** - Application 100% Java vanilla

---

## 💡 Fonctionnalités Avancées

### **Interface Utilisateur Moderne**
- ✨ Design system cohérent
- 🎨 Thème professionnel (bleu/gris)
- 🖱️ Interactions fluides (selection)

### **Gestion Intelligente des Stocks**
```java
// Alertes automatiques
if (medicine.isLowStock(threshold)) {
    showStockAlert(medicine);
}

// Prévention survente
if (quantityRequested > medicine.getStock()) {
    throw new StockInsuffisantException();
}
```

### **Calculs Automatiques**
```java
// Remboursement mutuelle
double calculateReimbursement(Purchase purchase) {
    if (purchase.isPrescriptionBased()) {
        double rate = customer.getMutuelle().getReimbursementRate();
        return purchase.getTotal() * rate;
    }
    return 0.0;
}
```

---


### **Historique Complet**
- 🕒 Filtrage par période (jour/semaine/mois)
- 👤 Historique par client/médecin

---

## 📋 Installation Détaillée

### **Étapes Complètes**

1. **Clonage du projet**
   ```bash
   git clone https://github.com/Leos51/sparadrap-ecf.git
   cd sparadrap-ecf
   ```

2. **Configuration IDE (IntelliJ)**
   ```
   File → Open → Sélectionner le dossier sparadrap-ecf
   Project Structure → SDK → Choisir Java 21
   ```

3. **Lancement**
   ```
   Localiser : src/fr/sparadrah/ecf/controller/Main.java
   Clic droit → Run 'Main'
   ```

4. **Première utilisation**
   - L'application démarre automatiquement
   - Les données de test se chargent
   - Interface prête à l'emploi





