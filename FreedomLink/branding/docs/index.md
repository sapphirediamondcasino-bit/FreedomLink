---
template: home.html
title: Home
description: Standalone audio sending node based on Lavaplayer.
hide:
  - footer
  - navigation
  - navigation.tabs
  - toc
  - path
---

## Features

::cards::

- title: Powered by Lavaplayer
  icon: ':material-music:'
  url: https://github.com/FreedomLink-devs/lavaplayer
- title: Minimal CPU/memory footprint
  icon: ':octicons-cpu-16:'
- title: Twitch/YouTube stream support
  icon: ':material-youtube:'
- title: Event system
  icon: ':fontawesome-solid-right-left:'
  url: api/websocket.md
- title: Seeking
  icon: ':material-fast-forward-10:'
  url: api/rest.md#update-player
- title: Volume control
  icon: ':material-volume-high:'
  url: api/rest.md#update-player
- title: Full REST API
  icon: ':material-api:'
  url: api/rest.md
- title: Statistics
  icon: ':octicons-graph-16:'
  url: api/rest.md#get-FreedomLink-stats
- title: Basic authentication
  icon: ':material-lock:'
  url: api/rest.md
- title: Prometheus metrics
  icon: ':simple-prometheus:'
  url: https://prometheus.io/
- title: Docker images
  icon: ':simple-docker:'
  url: configuration/docker.md
- title: Plugin support
  icon: ':material-power-plug-outline:'
  url: plugins.md

::/cards::

## Found a Bug?

If you found a bug, please report it on the [issue tracker](https://github.com/FreedomLink-devs/FreedomLink/issues/new?labels=bug&template=bug_report.md).

## Need Help?

Join the [FreedomLink support Discord]({{ discord_help }}) or open a [GitHub discussion](https://github.com/FreedomLink-devs/FreedomLink/discussions/new?category=q-a) for help or questions.
