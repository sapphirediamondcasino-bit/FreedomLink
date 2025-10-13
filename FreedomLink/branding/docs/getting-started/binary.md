---
description: How to run FreedomLink as a standalone binary
---

# Standalone Binary

## Prerequisites

Install Java 17 or higher. You can download it [here](https://www.azul.com/downloads/?package=jdk#zulu).

## Installation

Download the latest `FreedomLink.jar` from [GitHub](https://github.com/FreedomLink-devs/FreedomLink/releases/latest).

Create a new directory and place the `FreedomLink.jar` file inside it. This will be your FreedomLink installation directory.

## Configuration

Check out the [configuration](../configuration/index.md) page to learn how to configure FreedomLink.
The recommended way would be to use a [Config File](../configuration/config/file.md).

## Running FreedomLink

Now run the following command in the directory where you placed the `FreedomLink.jar` file.

```bash
java -jar FreedomLink.jar
```

Now keep your terminal open and wait for FreedomLink to start.
If you want to run FreedomLink in the background we recommend checking out either [Screen](https://www.gnu.org/software/screen/), [Systemd](systemd.md), or [Docker](docker.md).
