# MultiVersion MultiLoader Template

---

## Forked from [jaredlll08/MultiLoader-Template](https://github.com/jaredlll08/MultiLoader-Template)

---

This is a customized fork of the original MultiLoader Template.  
For full documentation, setup instructions, and general usage, please refer to the original [README](https://github.com/jaredlll08/MultiLoader-Template/blob/main/README.md).

## Modifications in this fork

This version introduces the following changes to support easier multi‑version and multi‑loader configuration:

- Set the target Minecraft version in `gradle.properties` under `minecraft_version`.
- Add a corresponding `${minecraft_version}.properties` file inside the `versions` directory for version‑specific settings.
- The build automatically includes or excludes loader‑specific subprojects (Fabric, NeoForge, Forge) based on whether the corresponding property (`fabric_version`, `neoforge_version`, `forge_version`) is defined in specified `${minecraft_version}.properties`.

These adjustments allow for more flexible version and loader management while maintaining compatibility with the original template structure.