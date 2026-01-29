# MultiVersion MultiLoader Template

---

## Forked from [jaredlll08/MultiLoader-Template](https://github.com/jaredlll08/MultiLoader-Template)

> This fork does **not** aim to achieve comprehensive cross-version compatibility that would let you instantly switch
> versions even when the toolchain introduces breaking changes.  
> Instead, it strives to make the most of existing toolchain capabilities with minimal invasive modifications to the
> original template, enabling you to develop across a wider range of versions as long as Mojang or the toolchain do not
> introduce breaking changes.
>
> This means it works best for maintaining a mod across multiple patch versions
> of the same major Minecraft release, or between releases where the toolchain
> hasn't introduced breaking changes. It won't magically bridge the vast gap in
> toolchains between distant versions like 1.16 and 1.21, where the build system
> and loader setups have shifted dramatically.

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
       #if MC1_21
       // Code that only compiles for Minecraft 1.21 (exact two‑segment version)
       #endif

       #if MC1_21_1
       // Code that only compiles for Minecraft 1.21.1
       #endif

       #if MC1_21_X
       // Code that compiles for all Minecraft 1.21.x versions (e.g. 1.21, 1.21.1, 1.21.2 …)
       #endif
       ```
    - The preprocessor directives are determined automatically from the `minecraft_version` property:
      * **Two‑segment versions** (e.g. `1.21`) define both `MC1_21` and the wildcard `MC1_21_X`.
      * **Three‑segment versions** (e.g. `1.21.1`) define `MC1_21_1` and the wildcard `MC1_21_X`.  
        (For three‑segment versions, the plain `MCmajor_minor` form like `MC1_21` is **not** defined.)
      * **Non‑standard versions** (snapshots, pre‑releases like `1.21-rc1`) define only a sanitized form
        (e.g. `MC1_21_RC1`). Wildcard preprocessing (such as `MC1_21_X`) is **not** available for these versions.
    - This allows you to write version‑specific code blocks that are automatically included or excluded during
      compilation based on the target `minecraft_version`. Use the `_X` wildcard to match an entire minor release
      family when your code is compatible across all patches of that family.

4. **JUnit 5 Testing Support**
    - Added `org.junit.jupiter:junit-jupiter` as a common test dependency, so unit tests can be written and executed
      across all loader subprojects out of the box.

These adjustments provide more explicit control over loader inclusion and enable powerful conditional compilation for
multi‑version support, while maintaining compatibility with the original template structure.