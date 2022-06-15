global using Xunit;
global using System;
global using Xunit.Abstractions;
global using Xunit.Sdk;
global using System.Text.Json;

[assembly: CollectionBehavior(DisableTestParallelization = true)]
[assembly: TestCollectionOrderer("XUnit.Project.Orderers.DisplayNameOrderer", "Test")]