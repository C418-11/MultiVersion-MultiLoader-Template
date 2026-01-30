# MultiVersion MultiLoader Template

---

## Forked from [jaredlll08/MultiLoader-Template](https://github.com/jaredlll08/MultiLoader-Template)

---

This is a customized fork of the original MultiLoader Template.  
For full documentation, setup instructions, and general usage, please refer to the
original [README](https://github.com/jaredlll08/MultiLoader-Template/blob/main/README.md).

## Modifications in this fork

This version introduces the following changes to support easier multi‑version and multi‑loader configuration:

1. **Centralized Version Configuration**
    - Set the target Minecraft version in `gradle.properties` under `minecraft_version`.
    - Add a corresponding `${minecraft_version}.properties` file inside the `versions` directory for version‑specific
      settings.

2. **Conditional Loader Subproject Inclusion**
    - The build automatically includes or excludes loader‑specific subprojects (Fabric, NeoForge, Forge) based on the
      corresponding property (`fabric_version`, `neoforge_version`, `forge_version`) defined in the
      `${minecraft_version}.properties` file.
    - A loader subproject is excluded when its property is explicitly set to `"null"` (as a string).  
      *Example:* `fabric_version=null` will exclude the Fabric subproject for that Minecraft version.

3. **Manifold Preprocessor Support**
    - Added the dependency `systems.manifold:manifold-preprocessor` to enable conditional compilation based on Minecraft
      versions.
    - In your source code, you can now use the following syntax:
       ```java
       #if MC1_21_11
       // Code that only compiles for Minecraft 1.21.11
       #endif

       #if MC1_21_8
       // Code that only compiles for Minecraft 1.21.8
       #endif
       ```
    - The preprocessor directives allow you to write version‑specific code blocks that are automatically included or
      excluded during compilation based on the target `minecraft_version`.

These adjustments provide more explicit control over loader inclusion and enable powerful conditional compilation for
multi‑version support, while maintaining compatibility with the original template structure.