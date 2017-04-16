---
title: "jSAM: Installation Guide"
excerpt: "How to install jSAM"
sitemap: true
layout: single
permalink: /install.html
---

To install the jSAM, [Eclipse for DSL](https://www.eclipse.org/home/index.php) and [Java 1.8](https://java.com/) are needed.

Open your copy of Eclipse for DSL, and select *Help >> Install New Software*.

![Eclipse menu: Install new software](assets/images/newsoftware.jpg)

Click *Add* to open add site dialogue

![Eclipse menu: Add new update site](assets/images/addjsamrepository.jpg)

Create jSAM Update Site repository and set the location to

[http://dl.bintray.com/michele-loreti/jSAM/updates/1.1/](http://dl.bintray.com/michele-loreti/jSAM/updates/1.1/)

![Data of jSAM Update Site](assets/images/jsamrepository.png)


Select the packages of interest from the category *jSAM Plugin* and click on the button *Next*

![Select jSAM plugins from update Site](assets/images/selectplugins.png)


The application will then find all the dependencies and get the plug-in for you (this can take some time as the application has to look up dependencies from other sites). After that you will be presented with installation details, just press *Next* to confirm the list of plugins to install.

![Confirm plugin installation](assets/images/confirmplugin.png)

When all the data have been downloaded accept the license agreement to start the installation.

![Accept license](assets/images/acceptlicense.png)

Accept installation

![Accept installation](assets/images/confirminstallation.png)

When the process is completed you need to restart Eclipse.

![Restart Eclipse](assets/images/restart.png)
